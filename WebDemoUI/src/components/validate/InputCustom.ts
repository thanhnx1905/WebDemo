
import { Watch, Component, Vue, toNative, Prop, Model, Emit } from 'vue-facing-decorator'
import { TypeData } from '../common/TypeData';

@Component({
    name: 'InputCustom'
})
class InputCustom extends Vue {

    @Prop()
    public modelValue!: string;

    public msg: string = "";

    @Prop
    typeData?: TypeData;

    @Prop({
        default: false
    })
    required?: boolean;

    @Prop({
        default: "text"
    })
    typeContent?: string = "text";

    public beforeCreate() {
        this.msg = '';
    }

    @Emit("update:modelValue")
    public updateModel(event: any) {
        return event.target.value;
    }

    @Watch("modelValue")
    public valueChange(value: string) {
        this.validate(value);
    }


    private validate(value: string) {
        //this.value = value;
        if (!this.required && value == '') {
            this.msg = '';
            return;
        }
        switch (this.typeData) {
            case TypeData.EMAIL:
                this.validateEmail(value)
                break;
            case TypeData.PASSWORD:
                this.validatePassword(value);
                break;
            case TypeData.PHONENUMBER:
                break;
            default:
                break
        }

    }

    private validateEmail(value: string) {
        if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(value)) {
            this.msg = '';
        } else {
            this.msg = 'Invalid Email Address';
        }
    }

    private validatePassword(value: string) {
        let difference = 8 - value.length;
        if (value.length < 8) {
            this.msg = 'Must be 8 characters! ' + difference + ' characters left';
        } else {
            this.msg = '';
        }
    }

}

export default toNative(InputCustom);
