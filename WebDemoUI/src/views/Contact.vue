<template>
    <div class="app">
        <HomeCom @showDialog1="showDialog22"></HomeCom>
    </div>
</template>
<script lang = "ts" setup>
import { ref, reactive } from 'vue';
import HomeCom from '../components/event/ButtonEvent.vue';
//const contenRecv2 = ref<number>(0);
const showDialog22 = (contenRecv: number) => {
	//contenRecv2.value = contenRecv;
};
</script>