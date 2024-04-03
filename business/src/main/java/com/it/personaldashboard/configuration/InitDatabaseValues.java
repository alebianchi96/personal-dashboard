package com.it.personaldashboard.configuration;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.it.personaldashboard.model.budgeting.BgtCategoryEntity;
import com.it.personaldashboard.model.budgeting.BgtSubCategoryEntity;
import com.it.personaldashboard.model.budgeting.BgtCategoryEntity.Nature;
import com.it.personaldashboard.model.budgeting.BgtPeriodEntity;

public class InitDatabaseValues {

        private InitDatabaseValues() {
        }

        public static List<BgtCategoryEntity> listInitBgtCategoryEntity() {
                return List.of(
                                new BgtCategoryEntity("Insussistenze",
                                                Nature.COST_OP),
                                new BgtCategoryEntity("Tasse", Nature.COST_OP),
                                new BgtCategoryEntity("Parcheggi",
                                                Nature.COST_OP),

                                new BgtCategoryEntity("Affitto casa",
                                                Nature.COST_PLAN),
                                new BgtCategoryEntity("Spesa mensile",
                                                Nature.COST_PLAN),
                                new BgtCategoryEntity("Bollette",
                                                Nature.COST_PLAN),
                                new BgtCategoryEntity("Benzina",
                                                Nature.COST_PLAN),
                                new BgtCategoryEntity("Pasti fuori",
                                                Nature.COST_PLAN),
                                new BgtCategoryEntity("F", Nature.COST_PLAN),
                                new BgtCategoryEntity("Spese annuali",
                                                Nature.COST_PLAN),
                                new BgtCategoryEntity("Capelli",
                                                Nature.COST_PLAN),
                                new BgtCategoryEntity("Telefono",
                                                Nature.COST_PLAN),
                                new BgtCategoryEntity("Commissioni bancarie",
                                                Nature.COST_PLAN),
                                new BgtCategoryEntity("Biglietti trasporti",
                                                Nature.COST_PLAN),
                                new BgtCategoryEntity("Vacanza",
                                                Nature.COST_PLAN),
                                new BgtCategoryEntity("Regali",
                                                Nature.COST_PLAN),
                                new BgtCategoryEntity("Salute",
                                                Nature.COST_PLAN),
                                new BgtCategoryEntity("Spese personali",
                                                Nature.COST_PLAN),
                                new BgtCategoryEntity("PAC", Nature.COST_PLAN),

                                new BgtCategoryEntity("Compleanno",
                                                Nature.REVENUES),
                                new BgtCategoryEntity("EuForLegal",
                                                Nature.REVENUES),
                                new BgtCategoryEntity("GinnerHub",
                                                Nature.REVENUES),
                                new BgtCategoryEntity("Interessi BBVA",
                                                Nature.REVENUES),
                                new BgtCategoryEntity("Parenti",
                                                Nature.REVENUES),
                                new BgtCategoryEntity("Giulia",
                                                Nature.REVENUES),
                                new BgtCategoryEntity("Mamma", Nature.REVENUES)

                );
        }

        public static List<BgtSubCategoryEntity> listInitBgtSubCategoryEntity() {
                return List.of(
                        new BgtSubCategoryEntity("Insussistenze", BigDecimal.ZERO, InitDatabaseValues.findFirstCategoryByName("Insussistenze")),
                        new BgtSubCategoryEntity("Tasse", BigDecimal.ZERO, InitDatabaseValues.findFirstCategoryByName("Tasse")),
                        new BgtSubCategoryEntity("Parcheggi", BigDecimal.ZERO, InitDatabaseValues.findFirstCategoryByName("Parcheggi")),
                        
                        new BgtSubCategoryEntity("Affitto casa", BigDecimal.valueOf(6288.00), InitDatabaseValues.findFirstCategoryByName("Affitto casa")),
                        new BgtSubCategoryEntity("Accessori iniziali", BigDecimal.valueOf(0.00), InitDatabaseValues.findFirstCategoryByName("Spesa mensile")),
                        new BgtSubCategoryEntity("Alimenti", BigDecimal.valueOf(4800.00), InitDatabaseValues.findFirstCategoryByName("Spesa mensile")),
                        new BgtSubCategoryEntity("Spesa varia", BigDecimal.valueOf(600.00), InitDatabaseValues.findFirstCategoryByName("Spesa mensile")),
                        
                        new BgtSubCategoryEntity("Luce", BigDecimal.valueOf(900.00), InitDatabaseValues.findFirstCategoryByName("Bollette")),
                        new BgtSubCategoryEntity("Gas", BigDecimal.valueOf(480.00), InitDatabaseValues.findFirstCategoryByName("Bollette")),
                        new BgtSubCategoryEntity("Acqua", BigDecimal.valueOf(360.00), InitDatabaseValues.findFirstCategoryByName("Bollette")),
                        new BgtSubCategoryEntity("Tari", BigDecimal.valueOf(360.00), InitDatabaseValues.findFirstCategoryByName("Bollette")),
                        new BgtSubCategoryEntity("Fastweb", BigDecimal.valueOf(300.00), InitDatabaseValues.findFirstCategoryByName("Bollette")),

                        new BgtSubCategoryEntity("Benzina", BigDecimal.valueOf(1440.00), InitDatabaseValues.findFirstCategoryByName("Benzina")),

                        new BgtSubCategoryEntity("Bar", BigDecimal.valueOf(120.00), InitDatabaseValues.findFirstCategoryByName("Pasti fuori")),
                        new BgtSubCategoryEntity("Pasti fuori", BigDecimal.valueOf(1080.00), InitDatabaseValues.findFirstCategoryByName("Pasti fuori")),

                        new BgtSubCategoryEntity("F", BigDecimal.valueOf(360.00), InitDatabaseValues.findFirstCategoryByName("F")),

                        new BgtSubCategoryEntity("Assicurazione", BigDecimal.valueOf(420.00), InitDatabaseValues.findFirstCategoryByName("Spese annuali")),
                        new BgtSubCategoryEntity("Bollo", BigDecimal.valueOf(180.00), InitDatabaseValues.findFirstCategoryByName("Spese annuali")),
                        new BgtSubCategoryEntity("Manutenzione auto", BigDecimal.valueOf(750.00), InitDatabaseValues.findFirstCategoryByName("Spese annuali")),
                        new BgtSubCategoryEntity("Caf", BigDecimal.valueOf(450.00), InitDatabaseValues.findFirstCategoryByName("Spese annuali")),
                        
                        new BgtSubCategoryEntity("Capelli", BigDecimal.valueOf(120.00), InitDatabaseValues.findFirstCategoryByName("Capelli")),
                        new BgtSubCategoryEntity("Telefono", BigDecimal.valueOf(95.88), InitDatabaseValues.findFirstCategoryByName("Telefono")),

                        new BgtSubCategoryEntity("Bollo BBVA", BigDecimal.valueOf(40.00), InitDatabaseValues.findFirstCategoryByName("Commissioni bancarie")),
                        new BgtSubCategoryEntity("Hype", BigDecimal.valueOf(36.00), InitDatabaseValues.findFirstCategoryByName("Commissioni bancarie")),
                        new BgtSubCategoryEntity("Altri", BigDecimal.valueOf(68.00), InitDatabaseValues.findFirstCategoryByName("Commissioni bancarie")),
                        
                        new BgtSubCategoryEntity("Biglietti trasporti", BigDecimal.valueOf(240.00), InitDatabaseValues.findFirstCategoryByName("Biglietti trasporti")),
                        new BgtSubCategoryEntity("Vacanza", BigDecimal.valueOf(1200.00), InitDatabaseValues.findFirstCategoryByName("Vacanza")),
                        new BgtSubCategoryEntity("Regali", BigDecimal.valueOf(1560.00), InitDatabaseValues.findFirstCategoryByName("Regali")),
                        new BgtSubCategoryEntity("Salute", BigDecimal.valueOf(240.00), InitDatabaseValues.findFirstCategoryByName("Salute")),
                        new BgtSubCategoryEntity("Spese personali", BigDecimal.valueOf(600.00), InitDatabaseValues.findFirstCategoryByName("Spese personali")),
                        
                        new BgtSubCategoryEntity("PAC", BigDecimal.valueOf(1200.00), InitDatabaseValues.findFirstCategoryByName("PAC")),
                        
                        new BgtSubCategoryEntity("Compleanno", BigDecimal.ZERO, InitDatabaseValues.findFirstCategoryByName("Compleanno")),
                        new BgtSubCategoryEntity("EuForLegal", BigDecimal.ZERO, InitDatabaseValues.findFirstCategoryByName("EuForLegal")),
                        new BgtSubCategoryEntity("GinnerHub", BigDecimal.ZERO, InitDatabaseValues.findFirstCategoryByName("GinnerHub")),
                        new BgtSubCategoryEntity("Interessi BBVA", BigDecimal.ZERO, InitDatabaseValues.findFirstCategoryByName("Interessi BBVA")),
                        new BgtSubCategoryEntity("Parenti", BigDecimal.ZERO, InitDatabaseValues.findFirstCategoryByName("Parenti")),
                        new BgtSubCategoryEntity("Giulia", BigDecimal.ZERO, InitDatabaseValues.findFirstCategoryByName("Giulia")),
                        new BgtSubCategoryEntity("Mamma", BigDecimal.ZERO, InitDatabaseValues.findFirstCategoryByName("Mamma"))
                );
        }

        private static BgtCategoryEntity findFirstCategoryByName(String name) {
                
                Optional<BgtCategoryEntity> optCategory = InitDatabaseValues.listInitBgtCategoryEntity()
                        .stream()
                        .filter(ct->ct.getName().equalsIgnoreCase(name))
                        .findFirst();

                if(optCategory.isEmpty()) { 
                        throw new IllegalArgumentException(
                                String.format("BgtCategoryEntity non esistente per name: %s", name)); 
                }
                
                return optCategory.get();

        }

        public static List<BgtPeriodEntity> listInitBgtPeriodEntity() {

                final List<String> listMonthsToCreate = List.of(
                        "Gennaio", "Febbraio", "Marzo", "Aprile",
                        "Maggio", "Giugno", "Luglio", "Agosto", "Settembre",
                        "Ottobre", "Novembre", "Dicembre"
                );

                int currentYear = LocalDate.now().getYear();

                List<Integer> listYearsToCreate = List.of(
                        currentYear-3, currentYear-2, currentYear-1, currentYear
                );

                List<BgtPeriodEntity> listPeriods = new ArrayList<>();

                for(Integer y : listYearsToCreate) {
                        for(String m : listMonthsToCreate){
                                listPeriods.add(new BgtPeriodEntity(m, y));
                        }
                }

                return listPeriods;
                
        }

}
