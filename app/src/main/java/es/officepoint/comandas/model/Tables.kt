package es.officepoint.comandas.model

object Tables {
    val tables : List<Table> = listOf(
            Table("Mesa 1", mutableListOf()),
            Table("Mesa 2", mutableListOf()),
            Table("Mesa 3", mutableListOf()),
            Table("Mesa 4", mutableListOf())
    )

    val count
    get() = tables.size

    fun getTable(index: Int) = tables[index]

    fun getIndex(table: Table) = tables.indexOf(table)

    operator fun get(index: Int) = tables[index]

    fun toArray() = tables.toTypedArray()
}

