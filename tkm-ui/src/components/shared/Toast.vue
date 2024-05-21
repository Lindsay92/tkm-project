<script>
export default {
    props: {
        id: {
            type: String,
            default: null,
        },
    },
};
</script>

<template>
    <div :id="id" class="toast-container p-3 d-flex justify-content-center align-items-center w-100">
        <div class="toast shadow-sm">
            <div class="toast-header">
                <strong class="text-dark me-auto">
                    {{ $t("common.toast.title") }}
                </strong>
                <button
                    type="button"
                    class="btn-close"
                    data-bs-dismiss="toast"
                ></button>
            </div>
            <div class="toast-body"></div>
        </div>
    </div>
</template>