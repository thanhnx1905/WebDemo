<template>
  <aside :class="`${is_expanded ? 'is-expanded' : ''}`">
    <div class="logo">
      <img :src="require(`../assets/img/${iconLogin}`)" alt="Vue" />
    </div>

    <div class="menu-toggle-wrap">
      <button class="menu-toggle" @click="ToggleMenu">
        <span class="material-icons"><img class="img-icon" src="../assets/img/arrow__right_icon.png" /></span>
      </button>
    </div>

    <h3>Menu</h3>
    <div class="menu">
      <router-link v-for="(item, index) in menuSidebar.mSidebarDetail.slice(0,
        menuSidebar.mSidebarDetail.length - 1
      )" :to="item.url" :key="index" class="button">
        <span class="material-icons"><img class="img-icon" :src="require(`../assets/img/${item.srcPath}`)"  /></span>
        <span class="text">{{ item.menuName }}</span>
      </router-link>
    </div>
    <div class="flex"></div>
    <div class="menu">
      <router-link v-for="(item, index) in menuSidebar.mSidebarDetail.slice(
        menuSidebar.mSidebarDetail.length - 1,
        menuSidebar.mSidebarDetail.length
      )" :to="item.url" :key="index" class="button">
        <span class="material-icons"><img class="img-icon" :src="require(`../assets/img/${iconPageLogin}`)"  /></span>
        <span class="text">{{ item.menuName }}</span>
      </router-link>
    </div>
  </aside>
</template>

<script lang="ts" setup>
import { ref, defineExpose, computed } from "vue";
import { defineProps } from "vue";
import { PropType } from "vue";
import MenuSidebar from "./common/MenuSidebar";
import { useStore } from 'vuex'

const is_expanded = ref(localStorage.getItem("is_expanded") === "true");

const store = useStore();

const iconLogin = computed(() => store.state.iconLogin);
const iconPageLogin = computed(() => store.state.iconPageLogin);

const ToggleMenu = () => {
  is_expanded.value = !is_expanded.value;
  localStorage.setItem("is_expanded", String(is_expanded.value));
};

const props = defineProps({
  menuSidebar: Object as PropType<InstanceType<typeof MenuSidebar>>,
});
</script>

<style lang="scss" scoped>
aside {
  display: flex;
  flex-direction: column;

  background-color: var(--dark);
  color: var(--light);

  width: calc(2rem + 32px);
  overflow: hidden;
  min-height: 100vh;
  padding: 1rem;

  transition: 0.2s ease-in-out;

  .img-icon {
    width: 2rem !important;
    max-width: fit-content;
  }

  .flex {
    flex: 1 1 0%;
  }

  .logo {
    margin-bottom: 1rem;

    img {
      width: 2rem;
    }
  }

  .menu-toggle-wrap {
    display: flex;
    justify-content: flex-end;
    margin-bottom: 1rem;

    position: relative;
    top: 0;
    transition: 0.2s ease-in-out;

    .menu-toggle {
      transition: 0.2s ease-in-out;

      .material-icons {
        font-size: 2rem;
        color: var(--light);
        transition: 0.2s ease-out;
      }

      &:hover {
        .material-icons {
          color: var(--primary);
          transform: translateX(0.5rem);
        }
      }
    }
  }

  h3,
  .button .text {
    opacity: 0;
    transition: opacity 0.3s ease-in-out;
  }

  h3 {
    color: var(--grey);
    font-size: 0.875rem;
    margin-bottom: 0.5rem;
    text-transform: uppercase;
  }

  .menu {
    margin: 0 -1rem;

    .button {
      display: flex;
      align-items: center;
      text-decoration: none;

      transition: 0.2s ease-in-out;
      padding: 0.5rem 1rem;

      .material-icons {
        font-size: 2rem;
        color: var(--light);
        transition: 0.2s ease-in-out;
      }

      .text {
        color: var(--light);
        transition: 0.2s ease-in-out;
      }

      &:hover {
        background-color: var(--dark-alt);

        .material-icons,
        .text {
          color: var(--primary);
        }
      }

      &.router-link-exact-active {
        background-color: var(--dark-alt);
        border-right: 5px solid var(--primary);

        .material-icons,
        .text {
          color: var(--primary);
        }
      }
    }
  }

  .footer {
    opacity: 0;
    transition: opacity 0.3s ease-in-out;

    p {
      font-size: 0.875rem;
      color: var(--grey);
    }
  }

  &.is-expanded {
    width: var(--sidebar-width);

    .menu-toggle-wrap {
      top: -3rem;

      .menu-toggle {
        transform: rotate(-180deg);
      }
    }

    h3,
    .button .text {
      opacity: 1;
    }

    .button {
      .material-icons {
        margin-right: 1rem;
      }
    }

    .footer {
      opacity: 0;
    }
  }

  @media (max-width: 1024px) {
    position: absolute;
    z-index: 99;
  }
}
</style>