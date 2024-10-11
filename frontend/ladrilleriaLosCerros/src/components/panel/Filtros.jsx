export default function Filtros() {
    return (
        <div>
            {/* Header */}
            <div className="flex justify-between items-center mb-4">
                <div className="flex gap-3">
                    <button className="text-sm hover:underline">Resetear</button>
                    <button className="text-sm bg-themePage text-white px-2 py-1 rounded hover:bg-themePage/80">
                        Aplicar
                    </button>
                </div>
            </div>

            {/* Date Range */}
            <div className="mb-4">
                <label className="block font-semibold text-sm mb-2">Rango de fechas</label>
                <div className="flex flex-col">
                    <input
                        type="date"
                        className="border p-1 rounded-lg w-full shadow-sm"
                        defaultValue="2014-01-01"
                    />
                    <span className="text-center">-</span>
                    <input
                        type="date"
                        className="border p-1 rounded-lg w-full shadow-sm"
                        defaultValue="2016-01-01"
                    />
                </div>
            </div>

            {/* Interval */}
            <div className="mb-4">
                <label className="block font-semibold text-sm mb-2">Intervalos</label>
                <div className="flex flex-col gap-2">
                    <label className="flex items-center">
                        <input
                            type="radio"
                            name="interval"
                            value="anual"
                            className="mr-2"
                        />
                        Anual
                    </label>
                    <label className="flex items-center">
                        <input
                            type="radio"
                            name="interval"
                            value="mensual"
                            className="mr-2"
                            defaultChecked
                        />
                        Mensual
                    </label>
                    <label className="flex items-center">
                        <input
                            type="radio"
                            name="interval"
                            value="trimestral"
                            className="mr-2"
                        />
                        Trimestral
                    </label>
                </div>
            </div>

            {/* Filtro adicional */}
            <div>
                <label className="block font-semibold text-sm mb-2">Filtro adicional</label>
                <div className="flex flex-col gap-2">
                    <label className="flex items-center">
                        <input
                            type="checkbox"
                            name="filtro_adicional"
                            className="mr-2"
                        />
                        Opcion 1
                    </label>
                    <label className="flex items-center">
                        <input
                            type="checkbox"
                            name="filtro_adicional"
                            className="mr-2"
                            
                        />
                        Opcion 2
                    </label>
                    <label className="flex items-center">
                        <input
                            type="checkbox"
                            name="filtro_adicional"
                            className="mr-2"
                        />
                        Opcion 3
                    </label>
                </div>
            </div>


        </div>
    );
}
