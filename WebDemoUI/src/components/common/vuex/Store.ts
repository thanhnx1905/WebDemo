import { State } from 'vue';
import { createStore } from 'vuex';

export default createStore<State>({
    state: {
        iconLogin: "logo.png",
        iconPageLogin: "login_icon.png",
    },
    mutations: {
        updateIconLogin(state, newIcon) {
            state.iconLogin = newIcon;
        },

        updateIconPageLogin(state, iconPageLogin: string) {
            state.iconPageLogin = iconPageLogin;
        },

    },
    getters: {
        getIconLogin(state): string {
            return state.iconLogin;
        },
        getIconPageLogin(state): string {
            return state.iconPageLogin;
        },
    },
});