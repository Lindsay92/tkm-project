import axios from 'axios';

const ACCEPTED_STATUS = [200, 201, 202, 204, 400];

export default {
    install: (app) => {
        const http = axios.create({
            baseURL: import.meta.env.VITE_API_BASE_URL,
            validateStatus: (status) => {
                return ACCEPTED_STATUS.includes(status);
            }
        });

        http.interceptors.response.use((response) => {
            const status = response.status;
            const data = response.data;
            const body = data != '' ? data : null;
            if (response.data.token) {
                const accessToken = data.token;
                const isAuthenticated = true;
                const role = data.role;
                const firstName = data.firstName;
                localStorage.clear();
                localStorage.setItem("token", accessToken);
                localStorage.setItem("isAuthenticated", isAuthenticated);
                localStorage.setItem("role", role);
                localStorage.setItem("userName", firstName);
            }
            return { status: status, body: body};
        }, (error) => {
            return Promise.reject(error);
        });

        http.interceptors.request.use(
            (config) => {
                const token = localStorage.getItem("token");
                const bearerToken = token ? `Bearer ${token}` : null;
                config.headers["Authorization"] = bearerToken;
                return config;
            },
            (error) => {
                console.log('error');
                return Promise.reject(error);
            }
        );


        app.config.globalProperties.$axios = http;
    }
};