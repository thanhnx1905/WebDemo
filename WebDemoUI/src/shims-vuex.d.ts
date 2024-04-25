import { ComponentCustomProperties } from 'vue'
import { Store } from 'vuex'

declare module '@vue/runtime-core' {

    export interface State {
        iconLogin: string;
        iconPageLogin: string;
    }

    export interface ComponentCustomProperties {
        $store: Store<State>;
    }
}