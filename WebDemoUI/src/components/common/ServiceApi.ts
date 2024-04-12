export default class ServiceApi {

    private static HOST: string = `${window.window.location.origin.replace(/3000/g, '8080')}/WebServer/webapi`;

    public static async login(api: string, param: any): Promise<any> {
        return this.fetchCommon(true, api, param).then((data: any) => {
            sessionStorage.setItem("token", data.token);
            sessionStorage.setItem("refresh-token", data.refreshToken);
        });
    }

    public static async fetchRefresh<T>(api: string, param: any): Promise<T> {
        return this.fetchCommon(true, api, param);
    }

    public static async fetch<T>(api: string, param: any): Promise<T> {
        return this.fetchCommon(false, api, param);
    }

    private static async fetchCommon<T>(refreshToken: boolean, api: string, param: any): Promise<T> {

        const formDataJsonString = JSON.stringify(param);
        const refresh_token: string = sessionStorage.getItem("refresh-token") == undefined ? "" : sessionStorage.getItem("refresh-token");
        const token: string = sessionStorage.getItem("token") == undefined ? "" : sessionStorage.getItem("token");
        const bearer: string = refreshToken ? refresh_token : token;
        const fetchOptions = {
            method: "POST",
            mode: "no-cors" as RequestMode,
            headers: {
                "Content-Type": "application/json",
                "Accept": "application/json",
                "Bearer": token
            },
            body: formDataJsonString,
        };

        const response = await fetch(`${this.HOST}/${api}`, fetchOptions);

        if (!response.ok) {
            const errorMessage = await response.text();
            throw new Error(errorMessage);
        }

        return <T>response.json();
    }

}