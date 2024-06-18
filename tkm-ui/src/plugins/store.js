import { defineStore } from 'pinia';

export const useStore = defineStore({
    id: 'main',
    state: () => ({
        favorites: [],
    }),
    actions: {
        addFavorite(activity) {
            this.favorites.push(activity);
        },
        removeFavorite(activity) {
            let index = this.favorites.indexOf(activity);
            if (index !== -1) {
                this.favorites.splice(index, 1);
            }
        },        
    },
    getters: {
        isFavorite: state => activity => {
            return state.favorites.some(id => id === activity);
        },
    },
});
