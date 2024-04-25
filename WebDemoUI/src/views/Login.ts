
import { Watch, Component, Vue, toNative, Prop, Model, Ref, Setup } from 'vue-facing-decorator'
import { TypeData } from '../components/common/TypeData'
import InputCustom from '../components/validate/Input.vue'
import ServiceApi from '../components/common/ServiceApi'
import ModalInfoOk from '../components/modal/info/ModalInfoOk.vue'
import { useStore } from 'vuex'

@Component({
    name: 'Login',
    components: {
        InputCustom,
        ModalInfoOk
    }
})
class Login extends Vue {

    public typePassword: string = "password";

    public parentPassword: string = "";

    public parentEmail: string = "";

    public checkData: boolean = false;

    public TypeData = TypeData;

    @Ref
    public modalInfoOk: any;

    @Setup((props, ctx) => useStore())
    public store: any;

    public logged: boolean;

    public loginInfo: string;

    public beforeCreate() {
        this.parentPassword = "";
        this.parentEmail = "";
        this.typePassword = "password";
    }

    public mounted() {
        this.logged = sessionStorage.getItem("logged") == "true";
        this.loginInfo = sessionStorage.getItem("loginInfo") == undefined ? "" : sessionStorage.getItem("loginInfo");
    }

    @Watch("checkData")
    public checkChange(value: any) {

    }

    @Watch("parentPassword")
    public checkPassword(value: any) {
    }

    public logout(){
        ServiceApi.logout("auth/logout").then(() =>{
            this.logged = false;
            this.loginInfo = "";
        }).catch((ex) =>{
            this.modalInfoOk.showDialog22("login error", ex.message, { width: "250px", height: "150px", top: "210px", left: `${(document.getElementsByClassName("logout")[0] as HTMLElement).offsetLeft + 100}px` });
        })
    }

    public registerInfo() {
        const token: string = sessionStorage.getItem("token") == undefined ? "" : sessionStorage.getItem("token");
        ServiceApi.login("auth/login", { "username": this.parentEmail, "password": this.parentPassword, "tokenId": token }).then((data) => {
            this.modalInfoOk.showDialog22("login info", "login successful", { width: "250px", height: "150px", top: "210px", left: `${(document.getElementsByClassName("register")[0] as HTMLElement).offsetLeft + 100}px` });
            //const store = useStore();
            this.store.commit("updateIconPageLogin", "logout_icon.png");
            this.logged = true;
            this.loginInfo = this.parentEmail;
            sessionStorage.setItem("loginInfo", this.parentEmail);
            sessionStorage.setItem("logged", "true");
        }).catch((ex) => {
            //this.logged = false;
            this.modalInfoOk.showDialog22("login error", ex.message, { width: "250px", height: "150px", top: "210px", left: `${(document.getElementsByClassName("register")[0] as HTMLElement).offsetLeft + 100}px` });
        });
    }

}

export default toNative(Login);