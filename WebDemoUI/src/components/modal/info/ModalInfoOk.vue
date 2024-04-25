<template>
    <div class="app-team">
        <Modal v-if="showModal" @closeDialogAll="showModal = false">
            <template v-slot:title>
                <div>{{textHeader}}</div>
            </template>
            <template v-slot:content>
                <div>{{ textContent }}</div>
            </template>

        </Modal>
    </div>
</template>
<script lang="ts" src="./ModelInfoOk.ts"> </script>
<style lang="css" scoped>
.app-team {
    display: flex;
    flex-direction: column;
    text-align: center;
    width: fit-content;
}
</style>