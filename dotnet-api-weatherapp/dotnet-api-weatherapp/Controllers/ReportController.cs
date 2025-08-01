using dotnet_api_weatherapp.Data;
using dotnet_api_weatherapp.Models;
using Microsoft.AspNetCore.Authorization;
using Microsoft.AspNetCore.Mvc;
using System.Security.Claims;

[ApiController]
[Route("api/[controller]")]
[Authorize]
public class ReportController : ControllerBase
{
    private readonly ApplicationDbContext _context;

    public ReportController(ApplicationDbContext context)
    {
        _context = context;
    }

    [HttpPost]
    public async Task<IActionResult> SaveReport(WeatherReport report)
    {
        report.UserId = int.Parse(User.FindFirst(ClaimTypes.NameIdentifier).Value);
        report.Date = DateTime.Now;

        _context.WeatherReports.Add(report);
        await _context.SaveChangesAsync();

        return Ok(report);
    }

    //[HttpGet]
    //public IActionResult GetUserReports()
    //{
    //    int userId = int.Parse(User.FindFirst(ClaimTypes.NameIdentifier).Value);
    //    var reports = _context.WeatherReports.Where(r => r.UserId == userId).ToList();
    //    return Ok(reports);
    //}
    [HttpGet]
    public IActionResult GetUserReports([FromQuery] string city = null)
    {
        int userId = int.Parse(User.FindFirst(ClaimTypes.NameIdentifier).Value);
        var query = _context.WeatherReports.Where(r => r.UserId == userId);

        if (!string.IsNullOrEmpty(city))
        {
            query = query.Where(r => r.City.ToLower().Contains(city.ToLower()));
        }

        var reports = query.OrderByDescending(r => r.Date).ToList();
        return Ok(reports);
    }

}
