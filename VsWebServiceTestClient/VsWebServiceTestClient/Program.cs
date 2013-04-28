using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
using System.Threading.Tasks;
using VsWebServiceTestClient.WsReference;

namespace VsWebServiceTestClient
{
    class Program
    {
        static void Main(string[] args)
        {
            TapWebService service = new TapWebServiceClient();
            getUserbyNameResponse response = service.getUserbyName(new getUserbyNameRequest("sasa"));

            Console.WriteLine("Full user name is " + response.@return.fullName);

            Console.ReadLine();
        }
    }
}
