<template>
	<main id="Home-page">
		<h1>Home</h1>
		<p>This is the about page</p>
		<span>{{ contenRecv2 }}</span>
		<HomeCom @showDialog1="showDialog22"></HomeCom>
	</main>
</template>
<script lang = "ts" setup>
import HomeCom from '../components/event/ButtonEvent.vue';
import { ref, reactive } from 'vue';
const contenRecv2 = ref<number>(0);
const showDialog22 = (contenRecv: number) => {
	contenRecv2.value = contenRecv;
};
</script>
