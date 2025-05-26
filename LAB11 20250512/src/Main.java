import java.util.List;

public class Main {
    public static void main(String[] args) {
        DzbanDAO dzbanDAO = new DzbanDAO();

        System.out.println("POCZĄTKOWA ZAWARTOŚĆ BAZY");
        printAll(dzbanDAO);

        Dzban dzban1 = new Dzban("Dzbanek Porcelanowy", "Biały z niebieskimi kwiatkami", 1500, 25);
        Dzban dzban2 = new Dzban("Dzban Gliniasty", "Rustykalny, ręcznie robiony", 2000, 30);

        dzbanDAO.add(dzban1);
        dzbanDAO.add(dzban2);

        System.out.println("\nPO DODANIU DWÓCH DZBANÓW");
        printAll(dzbanDAO);

        List<Dzban> lista = dzbanDAO.getAll();
        Dzban doAktualizacji = lista.get(0);
        doAktualizacji.setOpis("Zmieniony opis: piękny dzban z porcelany");
        dzbanDAO.update(doAktualizacji);

        System.out.println("\nPO AKTUALIZACJI OPISU PIERWSZEGO DZBANA");
        printAll(dzbanDAO);

        Dzban pojedynczy = dzbanDAO.getById(doAktualizacji.getId());
        System.out.println("\nSZCZEGÓŁY ZAKTUALIZOWANEGO DZBANA");
        System.out.println(pojedynczy);

        Dzban doUsuniecia = lista.get(1);
        dzbanDAO.delete(doUsuniecia.getId());

        System.out.println("\nPO USUNIĘCIU DRUGIEGO DZBANA");
        printAll(dzbanDAO);
    }

    private static void printAll(DzbanDAO dao) {
        List<Dzban> wszystkie = dao.getAll();
        if (wszystkie.isEmpty()) {
            System.out.println("Brak dzbanów w bazie.");
        } else {
            for (Dzban dzban : wszystkie) {
                System.out.println(dzban);
            }
        }
    }
}
