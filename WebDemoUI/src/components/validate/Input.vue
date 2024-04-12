<template>
    <input :class="msg != '' ? 'inputError' : 'inputOK'" :type="typeContent" :value="modelValue" @input="updateModel"
        :typeData="typeData" :required="required"> <br>
    <span v-if="msg">{{ msg }}</span>
</template>
<script lang="ts" src="./InputCustom.ts">
</script>
<style scoped>
span {
    padding-top: 0px;
    margin-top: 0px;
    font-size: 12px;
    color: red;
}

input,
inputOK {
    font-size: 30px;
    border: 1px double rgb(102, 97, 96);
    border-radius: 4px;
    width: 100%;

}

.inputOK:focus {
    border: 2px solid darkgreen !important;
    outline: none !important;
}

.inputError,
inputError:focus {
    border-color: red;
    outline: none !important;
}
</style>