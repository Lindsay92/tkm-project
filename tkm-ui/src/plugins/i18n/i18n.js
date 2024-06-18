import frMessages from "./fr.js";
import { createI18n } from "vue-i18n";


const shortDatetimeFormat = {
    year: 'numeric', month: 'short', day: '2-digit'
}
const longDatetimeFormat ={
    year: 'numeric', month: 'long', day: 'numeric'
}

const datetimeFormats = {
    'fr': {
        short: shortDatetimeFormat,
        long: longDatetimeFormat
    }
}
const i18n = createI18n({
    locale: 'fr',
    fallbackLocale: 'en',
    messages: {
        fr: frMessages,
    },
    datetimeFormats
})

export default i18n;
