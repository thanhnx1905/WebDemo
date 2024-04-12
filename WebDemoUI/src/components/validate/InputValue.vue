<template>
    <div id="visa">
        <form>
            <label for="email">Email Address:</label>
            <InputCustom :typeData="TypeData.EMAIL" /> <br>
            <label for="password">Password:</label>
            <InputCustom :typeData="TypeData.PASSWORD" /><br>
            <button class="login">Login</button>
        </form>
    </div>
</template>
<script setup>
import { TypeData } from '../common/TypeData';
import InputCustom from './Input.vue'
</script>
<style scoped>
form {
    display: flex;
    flex-direction: column;
    align-items: center;
}

label{
    text-align: left;
}
.login {
    height: 30px;
    width: 50px;
    background-color: forestgreen;
    border-radius: 5px;
}
</style>