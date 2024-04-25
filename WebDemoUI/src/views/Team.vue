<template>
    <div class="app-team">
        <h1>Team</h1>
        <Modal v-if="showModal" @closeDialogAll="showModal = false">
            <template v-slot:title>
                <div>Login form</div>
            </template>
            <template v-slot:content>
                <div>
                    <div id="visa">
                        <form>
                            <label for="email">Email Address:</label>
                            <InputCustom :typeData="TypeData.EMAIL" /> <br>
                            <label for="password">Password:</label>
                            <InputCustom :typeData="TypeData.PASSWORD" /><br>
                            <button class="login">Login</button>
                        </form>
                    </div>
                </div>
            </template>

        </Modal>
        <HomeCom @showDialog1="showDialog22"></HomeCom>
        <br>
        <div>{{ dataUser }}</div>

    </div>
</template>
<script lang="ts" setup>
import { ref, reactive } from 'vue';
import HomeCom from '../components/event/ButtonEvent.vue';
import Modal from '../components/modal/ModalDialog.vue';
import { TypeData } from '../components/common/TypeData';
import InputCustom from '../components/validate/Input.vue'
import ServiceApi from '../components/common/ServiceApi'

const showModal = ref<Boolean>(false);
const showDialog22 = (contenRecv: number) => {
    showModal.value = true;
};
const dataUser = ref<string>(null);
ServiceApi.fetchApi("load/data").then((data: any) => {
    dataUser.value = JSON.stringify(data);
}).catch((ex) => {
    dataUser.value = ex.message;
})
</script>
<style lang="css" scoped>
.app-team {
    display: flex;
    flex-direction: column;
    text-align: center;
    width: fit-content;
}

form {
    display: flex;
    flex-direction: column;
    align-items: center;
}

.login {
    height: 30px;
    width: 50px;
    background-color: forestgreen;
    border-radius: 5px;
    cursor: pointer;
}
</style>