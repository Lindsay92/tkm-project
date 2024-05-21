<template>
    <div class="footer container-fluid py-3 d-flex flex-wrap justify-content-between">
        <div>
            <span class="align-items-center "> &copy; {{ $t("shared.footer.copy") }}</span>
        </div>
        <div>
            <a href="" class="text-decoration-none"><span class="align-items-center text-dark link-footer">
                {{ $t("shared.footer.politics") }}
            </span></a>
            <a href="" class="text-decoration-none"><span class="align-items-center  text-dark link-footer">
                | {{ $t("shared.footer.mention") }}
            </span></a>
            <a href="" class="text-decoration-none"><span class="align-items-center text-dark link-footer">
                | {{ $t("shared.footer.mapSite") }}
            </span></a>
        </div>
    </div>
</template>