
import { Watch, Component, Vue, toNative, Prop, Model } from 'vue-facing-decorator'
import { TypeData } from '../components/common/TypeData'
import InputCustom from '../components/validate/Input.vue'
import ServiceApi from '../components/common/ServiceApi'

@Component({
    name: 'Login',
    components: {
        InputCustom
    }
})
class Login extends Vue {

    public typePassword: string  ="password";

    public parentPassword: string ="";

    public parentEmail: string ="";

    public checkData: boolean = false;

    public TypeData = TypeData;

    public beforeCreate() {
        this.parentPassword = "";
        this.parentEmail = "";
    }

    public mounted() {

    }

    @Watch("checkData")
    public checkChange(value: any) {

    }

    @Watch("parentPassword")
    public checkPassword(value: any) {
    }

    public registerInfo() {
        const token: string = sessionStorage.getItem("token") == undefined ? "" : sessionStorage.getItem("token");
        ServiceApi.login("auth/login", { "username": this.parentEmail, "password": this.parentPassword, "tokenId": token }).then((data) =>{
            alert("ex");
        }).catch((ex) =>{
            alert("ex");
        });
    }

}

export default toNative(Login);