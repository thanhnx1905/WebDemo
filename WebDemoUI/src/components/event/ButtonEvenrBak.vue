<template>
	<main id="Home-page">
		<div><button type="button" class="button" @click="showDialog">Show Dialog</button></div>
	</main>
</template>
<script lang="ts" setup>
import { defineProps, defineEmits, PropType, ref } from 'vue';

const contenRecv = ref<number>(0);

const emit = defineEmits(['showDialog1']);
const showDialog = () => {
	contenRecv.value++;
	emit('showDialog1', contenRecv);
};

</script>

<style lang="scss" scoped>
#Home-page {
	display: flex;
	flex-direction: column;

	.button {
		background-color: #4CAF50;
		/* Green */
		border: none;
		color: white;
		padding: 20px;
		text-align: center;
		text-decoration: none;
		display: inline-block;
		font-size: 16px;
		margin: 4px 2px;
		cursor: pointer;
		border-radius: 4px;
	}

}
</style>