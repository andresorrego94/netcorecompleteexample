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

            Get("/errortest", async (req, res) => {
                throw new ArgumentException("Error de prueba");
                await res.WriteAsync("Alive 3!");                
            });
        }
    }
}
