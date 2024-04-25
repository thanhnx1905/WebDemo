
import { Watch, Component, Vue, toNative, Prop, Model, Emit } from 'vue-facing-decorator'
import Modal from '../ModalDialog.vue';

@Component({
    name: 'ModalInfoOk',
    components: {
        Modal
    }
})
class ModalInfoOk extends Vue {

    public showModal: boolean = false;

    public textHeader: string = "";

    public textContent: string = "";

    public dialogCss: HTMLElement;

    private cssEdited: any;

    public beforeCreate() {

    }

    public mounted(){
        //this.dialogCss = document.getElementsByClassName("modal")[0] as HTMLElement;
    }

    public beforeUpdate(){
        //this.dialogCss = document.getElementsByClassName("modal")[0] as HTMLElement;
    }

    public updated() {
        this.dialogCss = document.getElementsByClassName("modal")[0] as HTMLElement;
        if (this.dialogCss) {
            this.dialogCss.style.width = this.cssEdited.width;
            this.dialogCss.style.height = this.cssEdited.height;
            this.dialogCss.style.top = this.cssEdited.top;
            this.dialogCss.style.left = this.cssEdited.left;
        }
    }

    public showDialog22(textHeader: string, textContent: string, styleCss?: any) {
        this.showModal = true;
        this.textHeader = textHeader;
        this.textContent = textContent;
        this.cssEdited = styleCss;
    }


}

export default toNative(ModalInfoOk);
