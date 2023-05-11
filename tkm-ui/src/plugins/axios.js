import axios from 'axios';

export default {
    install: (app) => {
        const http = axios.create({
            baseURL: import.meta.env.VITE_API_BASE_URL
        });

        http.interceptors.response.use((response) => {
            const data = response.data;
            const body = data != '' ? data : null;
            return { body: body};
        }, (error) => {
            return Promise.reject(error);
        });


        app.config.globalProperties.$axios = http;
    }
};