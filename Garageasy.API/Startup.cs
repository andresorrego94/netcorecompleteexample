using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;
using Carter;
using Microsoft.AspNetCore.Builder;
using Microsoft.AspNetCore.Hosting;
using Microsoft.AspNetCore.HttpsPolicy;
using Microsoft.AspNetCore.Mvc;
using Microsoft.Extensions.Configuration;
using Microsoft.Extensions.DependencyInjection;
using Microsoft.Extensions.Hosting;
using Microsoft.Extensions.Logging;

namespace Garageasy.API
{
    public class Startup
    {
        public IConfiguration Configuration { get; }
        public Startup(IConfiguration configuration)
        {
            Configuration = configuration;
        }

        public void ConfigureServices(IServiceCollection services)
        {
            services.AddCarter();

            //Services
            //services.AddSingleton<IActorProvider, ActorProvider>();

            //Repositories

            //Providers

            //Config
            //https://www.treinaweb.com.br/blog/criando-uma-api-restful-com-o-carter-e-net-core/

            //services.AddCarter(options =>
            //{
            //    options.OpenApi.DocumentTitle = this.appconfig.CarterOptions.OpenApi.DocumentTitle;
            //    options.OpenApi.ServerUrls = new[] { "http://localhost:5000" };
            //    options.OpenApi.Securities = new Dictionary<string, OpenApiSecurity>
            //    {
            //        { "BearerAuth", new OpenApiSecurity { BearerFormat = "JWT", Type = OpenApiSecurityType.http, Scheme = "bearer" } },
            //        { "ApiKey", new OpenApiSecurity { Type = OpenApiSecurityType.apiKey, Name = "X-API-KEY", In = OpenApiIn.header } }
            //    };
            //    options.OpenApi.GlobalSecurityDefinitions = new[] { "BearerAuth" };
            //});
        }

        public void Configure(IApplicationBuilder app, IWebHostEnvironment env)
        {
            app.UseExceptionHandler("/errorhandler");

            if (env.IsDevelopment())
            {
                app.UseDeveloperExceptionPage();
            }

            app.UseHttpsRedirection();

            app.UseRouting();

            //app.UseSwaggerUI(opt =>
            //{
            //    opt.RoutePrefix = "openapi/ui";
            //    opt.SwaggerEndpoint("/openapi", "Carter OpenAPI Sample");
            //});

            app.UseEndpoints(builder => builder.MapCarter());
        }
    }
}
