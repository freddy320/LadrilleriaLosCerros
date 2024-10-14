import { CiBullhorn } from "react-icons/ci";
import { MdOutlineMailOutline } from "react-icons/md";
import { PiNotePencilThin } from "react-icons/pi";
import { useState } from "react";

const Item = ({icon,title,desciption})=>{
    const [edit, setEdit] = useState(false);
    const [newDesciption, setNewDesciption] = useState(desciption);

    const handleEdit = () => {
        setEdit(!edit);
    }

    const handleEditDesciption = (e) => {
        setNewDesciption(e.target.value);
    }

    return(
        <div className="flex gap-2 p-2 bg-contrast rounded-xl shadow-xl items-center justify-center">
            <div className="w-24 h-24 basis-28 p-1 rounded-full flex items-center justify-center bg-themePage text-contrast">
                {icon} 
            </div>
            <div className="w-full text-center">
                <h2 className="text-3xl font-medium flex gap-2 items-center justify-center">{title} <PiNotePencilThin className="cursor-pointer" onClick={handleEdit} /></h2>
                {edit ? (
                    <input className="w-full h-full" type="text" value={newDesciption} onChange={handleEditDesciption} />
                ) : (
                    <p className="opacity-65">{newDesciption}</p>
                )}
            </div>
        </div>
    )
}

export function Anuncios() {
    return (
        <main className="grid gap-2 p-2">
            <header>
                <div className="flex justify-center items-center gap-2">
                <MdOutlineMailOutline  className="scale-150"/>Correo: xxxx@xxxx.com <PiNotePencilThin className="scale-110"/>
                </div>
            </header>
            <section className="grid gap-3 grid-cols-3 justify-center">
            <Item icon={<CiBullhorn className="scale-150 text-3xl" />} title="Recordario de pago" 
            desciption="Estimado usuario por favor recuerde que su pago debe de ser realizado antes de la fecha de vencimiento."
            />

            <Item icon={<CiBullhorn className="scale-150 text-3xl" />} title="Promocion de descuento"
            desciption="No te pierdas estos increibles descuentos que preparamos para ti el dia de hoy!!"
            />

            <Item icon={<CiBullhorn className="scale-150 text-3xl" />} title="Nuevos productos"
            desciption="Conoce nuestra nueva linea de productos que tenemos para ti, no te lo pierdas!!"
            />

            <Item icon = {<CiBullhorn className="scale-150 text-3xl" />} title="Tentacion de compra"
            desciption="Piensas contruir algo? no te pierdas nuestras ofertas en materiales de construccion!!"
            />

            <Item icon = {<CiBullhorn className="scale-150 text-3xl" />} title="Promocion de Compañia"
            desciption="Con nosotros siempre podras contar con materiales de alta calidad para contrurir tus sueños"
            />

            <Item icon = {<CiBullhorn className="scale-150 text-3xl" />} title="Recordario de pago vencido"
            desciption="Estimado usuario por favor recuerde que su pago esta vencido, por favor realice el pago lo mas pronto posible"
            />
            </section>
        </main>
    )
}