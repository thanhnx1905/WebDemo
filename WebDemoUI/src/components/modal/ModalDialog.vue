<template>
  <div :id="idModal">
    <div class="modal" @mousedown="modalMouseDown" @mouseup="modalMouseUp" @mousemove="modalMouseMove">
      <div class="modal-content">
        <div class="title">
          <slot name="title"></slot>
        </div>
        <hr class="line">
        <slot name="content"></slot>
        <hr class="line-buttom">
        <div class="wrapper"><button @click=closeDialog() class="button">Close</button></div>
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


const emit = defineEmits(['closeDialogAll']);
const closeDialog = () => {
  emit("closeDialogAll");
}

let dragObj = null;
let shiftX: number, shiftY: number;

const modalMouseDown = (event: MouseEvent) => {
  let target = (event.target as HTMLElement).closest('.modal');
  if (!target) return;
  dragObj = target;
  event.preventDefault();
  dragObj.style.position = 'absolute';
  //dragObj.style.zIndex = 1000;

  // Tính toán vị trí ban đầu của con trỏ chuột so với dialog
  shiftX = event.clientX - dragObj.getBoundingClientRect().left;
  shiftY = event.clientY - dragObj.getBoundingClientRect().top;
};

const moveAt = (event: MouseEvent) => {
  // Điều chỉnh vị trí của dialog dựa trên vị trí ban đầu của con trỏ chuột
  dragObj.style.left = event.pageX - shiftX + 'px';
  dragObj.style.top = event.pageY - shiftY + 'px';
}

const modalMouseMove = (event: MouseEvent) => {
  if (dragObj) {
    moveAt(event);
  }
};

const modalMouseUp = () => {
  dragObj = null;
};



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
  //border-radius: 10px;
  overflow: hidden;
}

.title {
  //background-color: #4CAF50;
  text-align: center;
  width: -webkit-fill-available;
  height: 40px;
  padding: 12px;
  background-color: #1aad8d;
  color: #fff;
}

.wrapper {
  text-align: center;
  position: absolute;
  bottom: 5px;
  left: 50%;
  transform: translateX(-50%);
  width: 100%;
}

.button {
  border: none;
  color: white;
  width: 60px;
  height: 30px;
  text-align: center;
  font-size: 16px;
  cursor: pointer;
  border-radius: 4px;
  background-color: #1aad8d;
  box-shadow: 0 8px 16px 0 rgba(0, 0, 0, 0.2), 0 6px 20px 0 rgba(0, 0, 0, 0.19);
  display: inline-block;
}

hr.line-buttom {
  position: absolute;
  bottom: 50px;
  width: 100%;
}
</style>