<template>
    <div class="app">
        <!-- <div class="nav">
            <router-link to="/">Home</router-link>|<router-link to="/about">About</router-link>|<router-link to="/login">Login</router-link>
        </div> -->
        <Sidebar :menuSidebar="dataMenuSidebar"/>
        <router-view />
    </div>
</template>
<script lang = "ts" setup>
import Sidebar from './components/Sidebar.vue';
import { ref, reactive } from 'vue';
import MenuSidebar from './components/common/MenuSidebar'
import MSidebarDetail from './components/common/MSidebarDetail'

let mSidebarDetails : Array<MSidebarDetail> = [];
mSidebarDetails.push(new MSidebarDetail("/", "home_house_icon.png", "Home"));
mSidebarDetails.push(new MSidebarDetail("/about", "about_icon.png", "About"));
mSidebarDetails.push(new MSidebarDetail("/team", "team_icon.png", "Team"));
mSidebarDetails.push(new MSidebarDetail("/contact", "contact_icon.png", "Contact"));
mSidebarDetails.push(new MSidebarDetail("/setting", "setting_icon.png", "Settings"));
    
const dataMenuSidebar = reactive(new MenuSidebar("logo.png", mSidebarDetails));
</script>
