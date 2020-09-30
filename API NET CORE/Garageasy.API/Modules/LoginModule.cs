using Carter;
using Carter.ModelBinding;
using Carter.Response;
using Garageasy.API.Models;

namespace Garageasy.API.Modules
{
    public class LoginModule: CarterModule
    {
        public LoginModule()
        {
            this.Post("/login", async (req, res) =>
            {
                var request = await req.Bind<Garager>();

                await res.Negotiate(new ApiResponse<Garager>
                {
                    Data = new Garager
                    {
                        Name = "TestName",
                        Direccion = "TestDireccion",
                        Username = $"Ingresaste como user {request.Name}",
                        Password = $"Ingresaste como pass {request.Password}"
                    }
                });
            });
        }
    }
}
