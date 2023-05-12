import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
import axios from './plugins/axios';
import dayjs from 'dayjs'

const app = createApp(App)

app.use(router)

app.use(axios);

app.config.globalProperties.$fmt = {
    date: (str) => {
        if (str === null) {
            return 'N/A';
        }
        const date = dayjs(str);
        return date.format('DD/MM/YYYY');
    }
};

app.mount('#app')
