<script>
export default {
    data() {
        return {
            isAuthenticated : localStorage.getItem("isAuthenticated"),
            role : localStorage.getItem("role"),
            userName : localStorage.getItem("userName"),
            accounts: []
        }
    },
    methods: {
        async initAccounts() {
            const response = await this.$axios.get('/accounts/for-view');
            this.accounts = response.body;
        },
        async remove(id){
            const response = await this.$axios.delete(`/accounts/${id}/for-delete`);
            if (response.status === 204) {
                this.$toast.success('toast-global', this.$t("common.status.delete"));
                window.scrollTo(0, 0);
                await this.initAccounts();
            }
            else {
                window.scrollTo(0, 0);
                this.$toast.error('toast-global', this.$t("common.status.failure"));
            }
        }   
    },
    beforeMount() {
        this.initAccounts();
    }
}
</script>

<template>
    <h1 class="text-center m-5">{{ $t('accountPage.title') }}</h1>
    <div class="table-responsive">
        <table class="table table-hover table-sm">
            <thead>
                <tr class="text-center align-middle">
                    <th scope="col">{{ $t('accountPage.firstName') }}</th>
                    <th scope="col">{{ $t('accountPage.lastName') }}</th>
                    <th scope="col">{{ $t('accountPage.email') }}</th>
                    <th scope="col">{{ $t('accountPage.role') }}</th>
                    <th scope="col">{{ $t('accountPage.delete') }}</th>
                </tr>
            </thead>
            <tbody class="text-wrap align-middle text-center table-group-divider">
                <tr v-for="account in accounts" :key="accounts.id">
                    <td>{{ account.firstName }}</td>
                    <td>{{ account.lastName }}</td>
                    <td>{{ account.email }}</td>
                    <td>{{ account.role.roleName }}</td>
                    <td class="text-center">
                        <a href="#" @click="remove(account.id)" title="Delete account">
                            <i class="bi bi-trash3 text-danger"></i>
                        </a>
                    </td>
                </tr>
            </tbody>
        </table>
    </div>
</template>