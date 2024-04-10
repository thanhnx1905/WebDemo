<template>
	<main id="about-page">
		<h1>About</h1>
		<p>This is the about page</p>
		<TVTableSample></TVTableSample>
	</main>
</template>
<script lang = "ts" setup>
import { defineComponent, ref } from 'vue';
import TVTableSample from '../components/table/TableSample.vue';

defineComponent({
    name: 'TableSample',
}) ;
</script>
