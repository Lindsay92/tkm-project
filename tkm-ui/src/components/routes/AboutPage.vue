<template>
  <h1 id="top" class="text-center m-5">
    {{ $t('aboutPage.title') }}
  </h1>
    <div class=" row align-items-center text-center m-5 justify-content-center">
      <p class="mb-5">
        {{ $t('aboutPage.description') }}
      </p>

      <div class="polaroid col-12 col-md-6">
        <img src="/images/lezard.jpg" alt="" class="image">
        <div class="container">
          <p>{{ $t('aboutPage.image1') }}</p>
        </div>
      </div>

      <div class="col-12 col-md-6">
        <h2>{{ $t('aboutPage.formality') }}</h2>
          <ul class="list-group list-group-flush">
            <li class="list-group-item">
              {{ $t('aboutPage.flight') }}
            </li>
            <li class="list-group-item">
              {{ $t('aboutPage.entry') }}
            </li>
            <li class="list-group-item">
              {{ $t('aboutPage.health') }}
            </li>
            <li class="list-group-item">
              {{ $t('aboutPage.lang') }}
            </li>
            <li class="list-group-item">
              {{ $t('aboutPage.currency') }}
            </li>
            <li class="list-group-item">
              {{ $t('aboutPage.hour') }}
            </li>
            <li class="list-group-item">
              {{ $t('aboutPage.weather') }}
            </li>
          </ul>
      </div>

      <div class="col-12 col-md-6">
        <p>{{ $t('aboutPage.description2') }}
          <br><br> 
          {{ $t('aboutPage.description3') }}
        </p>
      </div>
      
      <div class="polaroid col-12 col-md-6 m-4">
        <img src="/images/flower2.jpg" alt="" class="image">
        <div class="container">
          <p>{{ $t('aboutPage.image2') }}</p>
        </div>
      </div>

      <p class="mt-3">{{ $t('aboutPage.description4') }}</p>
    </div>

    <div class="row">
      <div class="d-flex justify-content-end p-4">
          <h2 class="btnColor" id="scrollUp">
            <a href="#top"><i class="bi bi-arrow-up-circle text-dark"></i></a>
          </h2>
      </div>
    </div>
</template>