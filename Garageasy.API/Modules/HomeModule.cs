using Carter;
using Microsoft.AspNetCore.Http;
using System;
using System.Collections.Generic;
using System.Linq;
using System.Threading.Tasks;

namespace Garageasy.API.Modules
{
    public class HomeModule: CarterModule
    {
        public HomeModule()
        {
            Get("/home", async (req, res) => await res.WriteAsync("Hello from Carter!"));

            Get("/test", async (req, res) => await res.WriteAsync("Alive !"));
        }

    }
}
