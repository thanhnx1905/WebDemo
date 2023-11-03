<template>
  <div :id="idModal">
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
  </div>
</template>
<script lang="ts" setup>
import { defineProps, defineEmits, PropType, ref } from 'vue';
import { onMounted, onBeforeUnmount } from 'vue'

let tag = ref<HTMLElement>();
const idModal = ref<string>(Math.floor(Math.random() * 10000).toString());

if (window.modalZIndex) {
  window.modalZIndex++;
} else {
  window.modalZIndex = 10;
}
onMounted(() => {

  tag.value = document.getElementById(idModal.value);
  (tag.value.getElementsByClassName("modal")[0] as HTMLElement).style.zIndex = (window.modalZIndex + 1).toString();
  let div = document.createElement("div");
  div.classList.add("background-drop", idModal.value);
  div.style.zIndex = window.modalZIndex.toString();
  document.getElementsByTagName("body")[0].appendChild(div);
})

onBeforeUnmount(() => {
  let div = document.getElementsByClassName(idModal.value)[0];
  document.getElementsByTagName("body")[0].removeChild(div);
})


const emit = defineEmits(['closeDialog']);
const closeDialog = () => {
  emit("closeDialog");
}
</script>
<style lang="scss">
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

.background-drop {
  position: fixed;
  top: 0;
  right: 0;
  bottom: 0;
  left: 0;
  background-color: #000;
  opacity: 0.5;
  /* z-index: 500; */
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
</style>

<style lang="scss" scoped>
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
  width: 50px;
  height: 20px;
  text-align: center;
  font-size: 16px;
  margin: 8px 2px;
  cursor: pointer;
  border-radius: 4px;
  position: absolute;
  background-color: #007bff;
  bottom: 0;
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