import org.jsoup.Jsoup
import java.io.File
import java.net.URI
import java.nio.file.Files
import java.nio.file.Paths

fun main(args: Array<String>) {
    println("Hello")
//    URI.create("http://www.footballdatabase.eu/fr/transferts").toURL().openStream().use { `in` -> Files.copy(`in`, Paths.get("scraper.html")) }

    val document = Jsoup.parse(File("scraper.html"), null, "http://www.footballdatabase.eu")

    for (transfers in document.select(".fulltransfers")) {
        for (date in transfers.select(".date")) {
            println("date: ${date.text()}")
            for (player in date.nextElementSibling().select(".name")) {
                if (player.text() != "Joueur") {
                    val playerName = player.select("a").text()
                    val nationality = player.select("span")[2].attr("title")
                    val fromTeam = player.nextElementSibling().selectFirst("a")?.text()
                    val fromNationality = player.nextElementSibling().select("span")[1].attr("title")
                    val toTeam = player.nextElementSibling().nextElementSibling().selectFirst("a")?.text()
                    val toNationality = player.nextElementSibling().nextElementSibling().select("span")[1].attr("title")
                    val amount = player.nextElementSibling().nextElementSibling().nextElementSibling().selectFirst("span")?.text()

                    print("\t$playerName [$nationality] from $fromTeam [$fromNationality] to $toTeam [$toNationality] for $amount\n")
                }
            }
            println("")
        }
    }
}