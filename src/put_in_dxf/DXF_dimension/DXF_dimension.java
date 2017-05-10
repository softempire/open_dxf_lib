package put_in_dxf.DXF_dimension;

import core.Color_dxf;
import core.Color_rgb;
import core.DXF_Utils;
import core.DXF_file;
import core.Section;
import core.Width;

public class DXF_dimension extends Section {

	/**
	 * Multiple line string of circle entity for add to SECTION_ENTITIES
	 */
	public String dxf_entity;
	public String dxf_tables_BLOCK_RECORDS;
	public String dxf_tables_BLKREFS;
	public String dxf_tables_ACAD_REACTORS;
	public String dxf_blocks;
	
	/**
	 * 
	 * @param x1
	 * @param y1
	 * @param x2
	 * @param y2
	 * @param x3
	 * @param y3
	 * @param ext_dim_lines size of Extend dimension lines
	 * @param ext_ticks size of Extend ticks
	 * @param dim_text_size
	 * @param dim_text_ss distanse between letters of text
	 * @param s text offset from dim line
	 * @param dim_text_change 
	 * 1 - text position unchanged, auto placing text;
	 * 2 - text position changed, text on dim line out of dim;
	 * 3 - text position changed, text on dim line between dim lines;
	 * @param text_x x coord of CENTER point of dim text
	 * @param text_y
	 * @param arrow_type
	 * @param angle 0 - horizontal, 90 - vertical 
	 * @param text if its "" then text is dimension distance
	 * @param color_rgb
	 */
	public DXF_dimension(
			double x1,
			double y1, 
			double x2,
			double y2, 
			double x3,
			double y3, 
			double ext_dim_lines,
			double ext_ticks,
			double dim_text_size,
			double dim_text_ss, 
			double s, 
			int dim_text_change,
			int text_x,
			int text_y,
			int angle, 
			String arrow_type,
			String text,
			Color_rgb color_rgb) {
		
		section_name = "dimention_entity.txt";
		body = super.init();
		Color_dxf color_dxf = new Color_dxf(color_rgb);
		
		dim_change DXF_dim_text_change = new dim_change(dim_text_change);
		core.DXF_file.dimension_index += 1;
		String dim_handle = core.DXF_file.hex_handle; //???String
		//Handles:
		values.put("handle", dim_handle);
		core.DXF_file.next_handle();
		values.put("handle_block_records_dim", core.DXF_file.hex_handle);
		core.DXF_file.next_handle();
		values.put("handle_block_dim", core.DXF_file.hex_handle);
		core.DXF_file.next_handle();
		values.put("handle_endblock_dim", core.DXF_file.hex_handle);
		core.DXF_file.next_handle();
		values.put("handle_block_dim_line_1", core.DXF_file.hex_handle);
		core.DXF_file.next_handle();
		values.put("handle_block_dim_line_2", core.DXF_file.hex_handle);
		core.DXF_file.next_handle();
		values.put("handle_block_dim_line_3", core.DXF_file.hex_handle);
		core.DXF_file.next_handle();
		values.put("handle_block_dim_insert_1", core.DXF_file.hex_handle);
		core.DXF_file.next_handle();
		values.put("handle_block_dim_blkrefs_insert_1", core.DXF_file.hex_handle);
		core.DXF_file.next_handle();
		values.put("handle_block_dim_insert_2", core.DXF_file.hex_handle);
		core.DXF_file.next_handle();
		values.put("handle_block_dim_blkrefs_insert_2", core.DXF_file.hex_handle);
		core.DXF_file.next_handle();
		values.put("handle_block_dim_mtext", core.DXF_file.hex_handle);
		core.DXF_file.next_handle();
		values.put("handle_block_dim_point_1", core.DXF_file.hex_handle);
		core.DXF_file.next_handle();
		values.put("handle_block_dim_point_2", core.DXF_file.hex_handle);
		core.DXF_file.next_handle();
		values.put("handle_block_dim_point_3", core.DXF_file.hex_handle);
		core.DXF_file.next_handle();
		
		
		
		values.put("color", color_dxf.get_dxf_color_string());
		values.put("x1", Double.toString(x1));
		values.put("y1", Double.toString(y1));
		values.put("x2", Double.toString(x2));
		values.put("y2", Double.toString(y2));
		values.put("x3", Double.toString(x3));
		values.put("y3", Double.toString(y3));
		values.put("ext_dim_lines", Double.toString(ext_dim_lines));
		values.put("ext_ticks", Double.toString(ext_ticks));
		values.put("dim_text_size", Double.toString(dim_text_size));
		values.put("text", text);
		values.put("DXF_dim_text_change", Integer.toString(DXF_dim_text_change.DXF_dim_text_change));
		values.put("DXF_dim_text_change2", Integer.toString(DXF_dim_text_change.DXF_dim_text_change2));
		values.put("dim_ind", "D"+Integer.toString(core.DXF_file.dimension_index));
		
		//Add dimension handle to ACAD_REACTORS in SECTION_TABLES
		dxf_tables_ACAD_REACTORS += ("330\n" + dim_handle + "\n");
		
		dxf_entity = DXF_Utils.replace_values(values, body);
	}

	@Override
	public String to_string() {
		return dxf_entity;
	}
}