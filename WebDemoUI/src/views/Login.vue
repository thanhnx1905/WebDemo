<template>
    <!--  Header -->
    <x-header></x-header>
    <!-- End Header -->
    <main id="main">
      <section id="contact" class="contact mb-5">
        <div class="container">
          <!-- <div class="row">
            <div class="col-lg-12 text-center mb-2">
              <h1 class="page-title">Login</h1>
            </div>
          </div> -->

          <div class="form mt-5">
            <div class="row">
              <div class="col-lg-6 mx-auto">
                <div id="formMessage"></div>
                <form action="#" method="post" id="auth-form" role="form" class="php-email-form">
                  <div class="form-group">
                    <input
                      type="email"
                      class="form-control"
                      name="email"
                      id="email"
                      placeholder="Your Email"
                      required
                    />
                  </div>
                  <div class="form-group">
                    <input
                      type="text"
                      class="form-control"
                      name="password"
                      id="password"
                      placeholder="Your Password"
                      required
                    />
                  </div>
                  <div class="text-center"><button type="submit">Submit</button></div>
                </form>
              </div>
            </div>
          </div>
          <!-- End Contact Form -->
        </div>
      </section>
    </main>
    <!-- End #main -->
    <x-footer></x-footer>

    <a href="#" class="scroll-top d-flex align-items-center justify-content-center"
      ><i class="bi bi-arrow-up-short"></i
    ></a>
</template>