<template>
    <div id="app">
        <div class="nav">
            <router-link to="/">Home</router-link>|<router-link to="/about">About</router-link>
        </div>
        <router-view />
    </div>
</template>
<script lang="ts">
import { defineComponent } from 'vue'
export default defineComponent({
    name: 'App',
})
</script>
<style lang="scss">
#app {
    text-align: center;

    .logo {
        width: 20%;
    }
}
.nav {
    padding: 30px 0 100px 0;

    a {
        font-weight: 500;
        color: var(--textColor);
        margin: 0 5px;
    }

    a.router-link-exact-active {
        color: var(--linkActiveColor);
    }
}
</style>