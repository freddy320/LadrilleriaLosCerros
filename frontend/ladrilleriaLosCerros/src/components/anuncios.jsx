import { CiBullhorn } from "react-icons/ci";
import { MdOutlineMailOutline } from "react-icons/md";
import { PiNotePencilThin } from "react-icons/pi";
import { CiSaveUp2 } from "react-icons/ci";
import { useState } from "react";
import { CiTurnL1 } from "react-icons/ci";
import { MdOutlineCancel } from "react-icons/md";




const Item = ({ icon, title, description }) => {
    const [active, setActive] = useState(false);
    const [edit, setEdit] = useState(false);
    const [newDescription, setNewDescription] = useState(description);

    const handleActive = (value) => {
        setActive(value);
    };

    const handleEdit = () => {
        setEdit(true);
    };

    const handleCancelEdit = () => {
        setNewDescription(description);
        setEdit(false);
    };

    const handleSaveEdit = (e) => {
        e.stopPropagation();
        setNewDescription(document.getElementById('text').value);
        setEdit(false);
        setActive(false);
    };

    const closeModal = (e) => {
        e.stopPropagation(); 
        handleActive(false);
    };

    return (
        <div
            className="flex flex-wrap p-2 bg-contrast rounded-xl shadow-xl items-center justify-center"
            onClick={() => handleActive(true)}
        >
            <header>
                <div className="flex flex-wrap gap-3 items-center text-2xl justify-center">
                    <div className="p-3 bg-themePage rounded-full text-contrast">
                        {icon}
                    </div>
                    <h2 className="text-center basis-40 shrink-0">{title}</h2>
                </div>
            </header>
            {active ? (
                <main className="absolute w-full h-full top-0 right-0 grid items-center justify-center">
                    <div className="bg-contrast h-96 w-80 z-50 rounded-xl p-2 shadow-xl" onClick={(e) => e.stopPropagation()}>
                        <header className="flex items-center justify-between text-xl">
                            <h2 className="font-semibold">{title}</h2>
                            <div className="flex gap-2">
                                {edit ? (<MdOutlineCancel className="opacity-70"  onClick={handleCancelEdit}/>) : null}
                                <PiNotePencilThin className="cursor-pointer" onClick={handleEdit} />
                                <CiTurnL1 className="cursor-pointer" onClick={closeModal} />
                            </div>
                        </header>
                        {edit ? (
                            <section>
                                <textarea
                                id="text"
                                className="w-full h-40 p-2 rounded-lg focus:outline-none"
                                defaultValue={description}
                                onChange={(e) => setNewDescription(e.target.value)}
                            ></textarea>
                            <div className="flex justify-center">
                                {edit ? <button className="p-2 flex gap-2 bg-themePage rounded-xl text-contrast items-center">
                                    Guardar<CiSaveUp2 className="scale-150" onClick={handleSaveEdit} />
                                </button> : null
                                }
                            </div>
                            </section>
                        ) : (
                            <p className="text-justify">{newDescription}</p>
                        )}
                    </div>
                    <div className="bg-black opacity-5 z-10 h-full w-full absolute"></div>
                </main>
            ) : null}
        </div>
    );
};


export function Anuncios() {
    return (

        <main className="h-full grid grid-cols-anuncios auto-rows-anuncios gap-4 justify-center relative p-2">
            <Item icon={<CiBullhorn className="scale-150 text-3xl" />} title="Recordario de pago"
                description="Estimado usuario por favor recuerde que su pago debe de ser realizado antes de la fecha de vencimiento."
            />

            <Item icon={<CiBullhorn className="scale-150 text-3xl" />} title="Promocion de descuento"
                description="No te pierdas estos increibles descuentos que preparamos para ti el dia de hoy!!"
            />

            <Item icon={<CiBullhorn className="scale-150 text-3xl" />} title="Nuevos productos"
                description="Conoce nuestra nueva linea de productos que tenemos para ti, no te lo pierdas!!"
            />

            <Item icon={<CiBullhorn className="scale-150 text-3xl" />} title="Tentacion de compra"
                description="Piensas contruir algo? no te pierdas nuestras ofertas en materiales de construccion!!"
            />

            <Item icon={<CiBullhorn className="scale-150 text-3xl" />} title="Promocion de Compañia"
                description="Con nosotros siempre podras contar con materiales de alta calidad para contrurir tus sueños"
            />

            <Item icon={<CiBullhorn className="scale-150 text-3xl" />} title="Recordario de pago vencido"
                description="Estimado usuario por favor recuerde que su pago esta vencido, por favor realice el pago lo mas pronto posible"
            />
        </main>

    )
}


/*

  <Item icon={<CiBullhorn className="scale-150 text-3xl" />} title="Recordario de pago"
                    description="Estimado usuario por favor recuerde que su pago debe de ser realizado antes de la fecha de vencimiento."
                />

                <Item icon={<CiBullhorn className="scale-150 text-3xl" />} title="Promocion de descuento"
                    description="No te pierdas estos increibles descuentos que preparamos para ti el dia de hoy!!"
                />

                <Item icon={<CiBullhorn className="scale-150 text-3xl" />} title="Nuevos productos"
                    description="Conoce nuestra nueva linea de productos que tenemos para ti, no te lo pierdas!!"
                />

                <Item icon={<CiBullhorn className="scale-150 text-3xl" />} title="Tentacion de compra"
                    description="Piensas contruir algo? no te pierdas nuestras ofertas en materiales de construccion!!"
                />

                <Item icon={<CiBullhorn className="scale-150 text-3xl" />} title="Promocion de Compañia"
                    description="Con nosotros siempre podras contar con materiales de alta calidad para contrurir tus sueños"
                />

                <Item icon={<CiBullhorn className="scale-150 text-3xl" />} title="Recordario de pago vencido"
                    description="Estimado usuario por favor recuerde que su pago esta vencido, por favor realice el pago lo mas pronto posible"
                />


*/