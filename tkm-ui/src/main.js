import { createApp } from 'vue';
import App from './App.vue';
import router from './router';
import axios from './plugins/axios';
import dayjs from 'dayjs';
import toast from './plugins/toast';

const app = createApp(App)

app.use(router)

app.use(axios);

app.use(toast);

// app.config.errorHandler = (err, comp) => {
//     console.error('Vue Global ErrorHandler', err);
//     comp.$toast.error('toast-global', 'A mystic error occurred, sorry for the inconvenience.');
// };

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
