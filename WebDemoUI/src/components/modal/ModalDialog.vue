<template>
  <div class="modal">
    <div class="modal-content">
      <div class="title">
        <slot name="title"></slot>
      </div>
      <hr class="line">
      <slot name="content"></slot>
      <hr class="line-buttom">
      <button @click=closeDialog() class="button">Close</button>
    </div>
  </div>
</template>
<script lang="ts" setup>
import { defineProps, defineEmits, PropType, ref } from 'vue';
const emit = defineEmits(['closeDialog']);
const closeDialog = () => {
  emit("closeDialog");
};
</script>
<style lang="scss" scoped>
.animatetop {
  -webkit-animation-name: animatetop;
  -webkit-animation-duration: 0.4s;
  animation-name: animatetop;
  animation-duration: 0.4s;
}

.animatebottom {
  -webkit-animation-name: animatebot;
  -webkit-animation-duration: 0.4s;
  animation-name: animatebot;
  animation-duration: 0.4s;
}

@-webkit-keyframes animatetop {
  from {
    top: -300px;
    opacity: 0;
  }

  to {
    top: 0;
    opacity: 1;
  }
}

@keyframes animatetop {
  from {
    top: -300px;
    opacity: 0;
  }

  to {
    top: 0;
    opacity: 1;
  }
}

@-webkit-keyframes animatebot {
  from {
    top: 0;
    opacity: 1;
  }

  to {
    top: -300px;
    opacity: 0;
  }
}

@keyframes animatebot {
  from {
    top: 0;
    opacity: 1;
  }

  to {
    top: -300px;
    opacity: 0;
  }
}


.modal {
  position: fixed;
  width: 500px;
  height: 500px;
  left: calc(50% - 250px);
  top: 50px;
}

.modal-content {
  overflow-y: initial !important;
  width: 100%;
  height: inherit;
  position: relative;
  pointer-events: auto;
  background-color: #fff;
  background-clip: padding-box;
  border: 1px solid rgba(0, 0, 0, 0.7);
  outline: none;
  border-radius: 10px;
  overflow: hidden;
}

.button {
  border: none;
  color: white;
  padding: 10px;
  text-align: center;
  font-size: 16px;
  margin: 4px 2px;
  cursor: pointer;
  border-radius: 4px;
  position: absolute;
  bottom: 0;
  background-color: #007bff;
  border-color: #007bff;
}

.title {
  //background-color: #4CAF50;
  text-align: center;
  width: -webkit-fill-available;
  height: 40px;
}

hr.line-buttom {
  position: absolute;
  bottom: 50px;
  width: 100%;
}
</style>