export default class ServiceApi {

    private static HOST: string = `${window.window.location.origin.replace(/3000/g, '8080')}/DDDServer/webapi`;

    public static async login(api: string, param: any): Promise<any> {
        return this.fetchCommon(true, api, param).then((data: any) => {
            sessionStorage.setItem("token", data.token);
            sessionStorage.setItem("refresh-token", data.refreshToken);
        });
    }

    public static async logout(api: string): Promise<any> {
        return this.fetchCommon(true, api, false).then((data: any) => {
            sessionStorage.removeItem("token");
            sessionStorage.removeItem("refresh-token");
            sessionStorage.removeItem("loginInfo");
            sessionStorage.removeItem("logged");
        });
    }

    public static async fetchRefresh<T>(api: string): Promise<T> {
        return this.fetchCommon(true, api);
    }

    public static async fetchApi<T>(api: string, param?: any,): Promise<T> {
        return this.fetchCommon(false, api, param);
    }

    public static async fetchNoRefresh<T>(api: string, param?: any): Promise<T> {
        return this.fetchCommon(false, api, param);
    }

    private static async fetchCommon<T>(refreshToken: boolean, api: string, param?: any): Promise<T> {
        const refresh_token: string = sessionStorage.getItem("refresh-token") == undefined ? "" : sessionStorage.getItem("refresh-token");
        const token: string = sessionStorage.getItem("token") == undefined ? "" : sessionStorage.getItem("token");
        const bearer: string = refreshToken ? refresh_token : token;

        const headers = new Headers();
        headers.append('Accept', 'application/json');
        headers.append('Content-Type', 'application/json;charset=UTF-8');
        if (bearer != "") headers.append('Authorization', "Bearer " + bearer);

        const fetchOptions = {
            method: "POST",
            mode: "cors" as RequestMode,
            credentials: "include" as RequestCredentials,
            redirect: "follow" as RequestRedirect,
            headers: headers,
            //body: JSON.stringify(param),
        };

        if (param) {
            fetchOptions["body"] = JSON.stringify(param);
        }

        try {
            const response = await fetch(`${this.HOST}/${api}`, fetchOptions);
            if (response.ok) {
                return this.responseOk(response);
            } else {
                const error = await response.text();
                if (error == "refresh token") {
                    return this.fetchRefresh("auth/renew_session").then((data: any) => {
                        sessionStorage.setItem("token", data.token);
                        sessionStorage.setItem("refresh-token", data.refreshToken);
                        return data.token;
                    }).then((newToken) => {
                        if (bearer != "") {
                            headers.set('Authorization', "Bearer " + newToken);
                        }
                        return fetch(`${this.HOST}/${api}`, fetchOptions);
                    }).then((responseOkResult: any) => {
                        if (responseOkResult.ok) {
                            return this.responseOk(responseOkResult);
                        } else {
                            throw new Error("An unknown error occurred.");
                        }
                    }).then((result) => {
                        return result as T;
                    }).catch((ex) => {
                        throw ex;
                    });
                } else if (error == "token expired") {
                    sessionStorage.removeItem("token");
                    sessionStorage.removeItem("refresh-token");
                    sessionStorage.removeItem("loginInfo");
                    sessionStorage.removeItem("logged");
                    fetch(`${this.HOST}/${api}`, fetchOptions);
                    throw new Error("token expires");
                } else {
                    throw new Error(error || "An unknown error occurred.");
                }
            }
        } catch (error) {
            throw error;
        }
    }

    private static async responseOk<T>(response: any): Promise<T> {
        return response.text().then((text: string) => {
            if (text) {
                try {
                    let data = JSON.parse(text);
                    return data as T;
                } catch (error) {
                    throw new Error('Error parsing JSON:' + error);
                }
            } else {
                return { ok: 200 } as T
            }
        });
    }

}