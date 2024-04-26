<template>
    <div id="loginform" v-if="!logged">
        <div class = "form">
            <div class="imgcontainer">
                <img src="../assets/img/img_avatar2.png" alt="Avatar" class="avatar">
            </div>
            <div class="container">
                <label for="email">Email Address:</label> <br>
                <InputCustom :typeData="TypeData.EMAIL" v-model="parentEmail" /> <br>
                <label for="password">Password:</label> <br>
                <InputCustom :typeContent="typePassword" :typeData="TypeData.PASSWORD" v-model="parentPassword" /><br>
                <button type="submit" @click="registerInfo">Login</button>
                <label>
                    <input type="checkbox" v-model="checkData" name="remember"> Remember me
                </label>
            </div>
            <div class="container" style="background-color:#f1f1f1">
                <span class="register">Register <a href="#">Register?</a></span>
                <span class="psw">Forgot <a href="#">password?</a></span>
            </div>
        </div>
    </div>
    <div id="logoutform" v-else>
        <div><label for="email">{{loginInfo}}</label> <br>
        <button type="submit" class = "logout" @click="logout">Logout</button>
        </div>
    </div>
    <ModalInfoOk ref="modalInfoOk" />
</template>
<script lang="ts" src="./Login.ts">
</script>
<style lang="css" scoped>
#loginform,
#logoutform {
    margin: auto;
}

.form {
    border: 3px solid #f1f1f1;
    display: flex;
    flex-direction: column;
    align-items: center;
}

input[type=text],
input[type=password] {
    width: 100% !important;
}

button {
    background-color: #04AA6D;
    color: white;
    padding: 14px 20px;
    margin: 8px 0;
    border: none;
    cursor: pointer;
    width: 100%;
}

button:hover {
    opacity: 0.8;
}

.cancelbtn {
    width: auto;
    padding: 10px 18px;
    background-color: #f44336;
}

.imgcontainer {
    text-align: center;
    margin: 24px 0 12px 0;
}

img.avatar {
    width: 40%;
    border-radius: 50%;
    margin: auto;
}

.container {
    padding: 16px;
}

span.psw {
    float: right;
    padding-top: 16px;
}

span.register {
    float: left;
    padding-top: 16px;
    color: green;
}

/* Change styles for span and cancel button on extra small screens */
@media screen and (max-width: 300px) {
    span.psw {
        display: block;
        float: none;
    }

    .cancelbtn {
        width: 100%;
    }
}
</style>