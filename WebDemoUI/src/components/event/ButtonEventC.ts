import { Component, Emit, Vue, toNative } from 'vue-facing-decorator';

@Component({
    name: 'ButtonEvent'
})
class ButtonEventC extends Vue {
    contenRecv: number = 0;

    @Emit("showDialog1")
    public showDialog(): number {
        this.contenRecv++;
        return this.contenRecv;
    };
}

export default toNative(ButtonEventC);
