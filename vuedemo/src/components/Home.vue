<template>
  <div style="height: 100%;">
    <nav-menu></nav-menu>
    <div style="height: 94.3283958435%; padding-top: 61px;">
      <router-view />
    </div>
  </div>
</template>

<script>
import NavMenu from "./common/NavMenu";
export default {
  name: "Home",
  components: { NavMenu },
};
</script>

<style>
html,body{
	width: 100%;
	height: 100%;
}
</style>

