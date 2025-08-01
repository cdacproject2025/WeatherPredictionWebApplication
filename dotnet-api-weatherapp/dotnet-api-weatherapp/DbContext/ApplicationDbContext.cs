using Microsoft.EntityFrameworkCore;
using dotnet_api_weatherapp.Models;

namespace dotnet_api_weatherapp.Data
{
    public class ApplicationDbContext : DbContext
    {
        public ApplicationDbContext(DbContextOptions<ApplicationDbContext> options)
            : base(options)
        {
        }

        public DbSet<User> Users { get; set; }
        public DbSet<WeatherReport> WeatherReports { get; set; }
    }
}
