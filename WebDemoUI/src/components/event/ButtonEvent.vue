<!-- ButtonEvent.vue -->
<template>
	<main id="Home-page">
		<div><button type="button" class="button" @click="showDialog">Show Dialog</button></div>
	</main>
</template>

<script lang="ts">
import { defineComponent } from 'vue';
import useButtonEvent from './ButtonEvent';

export default defineComponent({
  name: 'ButtonEvent',
  setup(_, { emit }) {
    const { showDialog } = useButtonEvent(emit);
    return { showDialog };
  },
});
</script>

<style lang="scss" scoped src="./ButtonEvent.scss">

</style>
