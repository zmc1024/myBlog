import Vue from 'vue'
import App from './App.vue'
import router from './router'
import ElementUI from 'element-ui';
import 'element-ui/lib/theme-chalk/index.css';
import axios from 'axios'
import mavonEditor from 'mavon-editor'
import 'mavon-editor/dist/css/index.css'
import md5 from 'js-md5'

Vue.prototype.$md5 = md5
Vue.prototype.$http = axios
axios.defaults.baseURL = "http://localhost:9000"

Vue.use(ElementUI);
Vue.use(mavonEditor);

Vue.config.productionTip = false

new Vue({
  router,
  render: h => h(App)
}).$mount('#app')
