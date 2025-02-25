package solides;

/**
 * Représente un cube, qui est un type de solide.
 * Cette classe permet de calculer le volume, la surface et de formater la représentation STL du cube.
 * Le cube est défini par la longueur de son côté et le matériau utilisé.
 * La longueur du côté est validée pour être dans une plage de valeurs définie.
 */
public class Cube{
    /**
     * La longueur du côté du cube.
     */
    private double cote;

    // TODO: Implémenter tout le reste de la classe (constructeurs, validation, méthodes de calcul, etc.)

    /**
     * Formate le cube en une chaîne de caractères au format STL pour l'exportation.
     * Le format STL décrit la géométrie du cube pour une impression 3D.
     *
     * @return La représentation STL du cube.
     */
    public String formaterSTL() {
        return "solid cube\n" +
                "  facet normal 0 0 1\n" +
                "    outer loop\n" +
                "      vertex 0 0 " + cote + "\n" +
                "      vertex " + cote + " 0 " + cote + "\n" +
                "      vertex 0 " + cote + " " + cote + "\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "  facet normal 0 0 1\n" +
                "    outer loop\n" +
                "      vertex " + cote + " 0 " + cote + "\n" +
                "      vertex " + cote + " " + cote + " " + cote + "\n" +
                "      vertex 0 " + cote + " " + cote + "\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "\n" +
                "  facet normal 0 0 -1\n" +
                "    outer loop\n" +
                "      vertex 0 0 0\n" +
                "      vertex 0 " + cote + " 0\n" +
                "      vertex " + cote + " 0 0\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "  facet normal 0 0 -1\n" +
                "    outer loop\n" +
                "      vertex " + cote + " 0 0\n" +
                "      vertex 0 " + cote + " 0\n" +
                "      vertex " + cote + " " + cote + " 0\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "\n" +
                "  facet normal 0 1 0\n" +
                "    outer loop\n" +
                "      vertex 0 " + cote + " 0\n" +
                "      vertex 0 " + cote + " " + cote + "\n" +
                "      vertex " + cote + " " + cote + " 0\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "  facet normal 0 1 0\n" +
                "    outer loop\n" +
                "      vertex " + cote + " " + cote + " 0\n" +
                "      vertex 0 " + cote + " " + cote + "\n" +
                "      vertex " + cote + " " + cote + " " + cote + "\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "\n" +
                "  facet normal 0 -1 0\n" +
                "    outer loop\n" +
                "      vertex 0 0 0\n" +
                "      vertex " + cote + " 0 0\n" +
                "      vertex 0 0 " + cote + "\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "  facet normal 0 -1 0\n" +
                "    outer loop\n" +
                "      vertex " + cote + " 0 0\n" +
                "      vertex " + cote + " 0 " + cote + "\n" +
                "      vertex 0 0 " + cote + "\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "\n" +
                "  facet normal 1 0 0\n" +
                "    outer loop\n" +
                "      vertex " + cote + " 0 0\n" +
                "      vertex " + cote + " " + cote + " 0\n" +
                "      vertex " + cote + " 0 " + cote + "\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "  facet normal 1 0 0\n" +
                "    outer loop\n" +
                "      vertex " + cote + " 0 " + cote + "\n" +
                "      vertex " + cote + " " + cote + " 0\n" +
                "      vertex " + cote + " " + cote + " " + cote + "\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "\n" +
                "  facet normal -1 0 0\n" +
                "    outer loop\n" +
                "      vertex 0 0 0\n" +
                "      vertex 0 0 " + cote + "\n" +
                "      vertex 0 " + cote + " 0\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "  facet normal -1 0 0\n" +
                "    outer loop\n" +
                "      vertex 0 0 " + cote + "\n" +
                "      vertex 0 " + cote + " " + cote + "\n" +
                "      vertex 0 " + cote + " 0\n" +
                "    endloop\n" +
                "  endfacet\n" +
                "endsolid cube\n";
    }
}
