<template>
    <div class="app-team">
        <h1>Team</h1>
        <Modal v-if="showModal" @closeDialog="showModal = false">
            <template v-slot:title>
                <div>Title</div>
            </template>
            <template v-slot:content>
                <div>Content</div>
            </template>

        </Modal>
        <HomeCom @showDialog1="showDialog22"></HomeCom>
    </div>
</template>
<script lang = "ts" setup>
import { ref, reactive } from 'vue';
import HomeCom from '../components/event/ButtonEvent.vue';
import Modal from '../components/modal/ModalDialog.vue';
const showModal = ref<Boolean>(false);
const showDialog22 = (contenRecv: number) => {
    showModal.value = true;
};
</script>
<style lang="scss" >
.app-team {
    display: flex;
    flex-direction: column;
    text-align: center;
    width: fit-content;
}
</style>